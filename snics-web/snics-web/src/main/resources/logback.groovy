
import mx.com.sagarpa.snics.common.config.AppConfig
import org.apache.commons.configuration.Configuration
import java.util.logging.LogManager.RootLogger
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

println " ################### START LOGBACK CONFIGURATION #####################"
Configuration config = new AppConfig()

//scan for changes every minute
//scan("45 seconds") //dont enable this until you fix the issue that when the file reloads, log is suspended.

String patternStr = config.getString("LOG.PATTERN")
println " ###################  LogPath[${config.getString('APP.LOG.PATH')}] LogFile[${config.getString('APP.LOG.NAME')}] pattern[${patternStr}] #####################   "

appender("STDOUT", ConsoleAppender){
	encoder(PatternLayoutEncoder) { pattern = patternStr }
}

appender("FILE", RollingFileAppender){
	append = true
	file = "${config.getString('APP.LOG.PATH')}/${config.getString('APP.LOG.NAME')}"
	rollingPolicy(TimeBasedRollingPolicy){
		fileNamePattern = "${config.getString('APP.LOG.PATH')}/%d{yyyy-MM-dd}_${config.getString('APP.LOG.NAME')}.zip"
		maxHistory = 30
	}
	encoder(PatternLayoutEncoder) { pattern = patternStr}
}

//frameworks
//------  SPRING -----
logger("org.springframework", DEBUG, ["STDOUT", "FILE"])
logger("org.hibernate", INFO, ["STDOUT", "FILE"])

void processLoggingConf(def config) {
	//Configuracion especifica del ambiente ( sobreescribe a la configuracion basica )
	//mx.com.prosa:DEBUG=FILE-CONSOLE-FILE,
	def items = config//config.getStringArray('LOG.PACKAGES.CONF')
	items.each{item ->
		try
		{
			def aux = item.split(":")
			def pkg = aux[0]
			def level = aux[1]
			//TRACE, DEBUG, INFO, WARN ERROR and OFF

			switch(level) {
				case "TRACE" : logger(pkg, TRACE) ; break;
				case "DEBUG" : logger(pkg, DEBUG) ; break;
				case "INFO"  : logger(pkg, INFO)  ; break;
				case "WARN"  : logger(pkg, WARN)  ; break;
				case "ERROR" : logger(pkg, ERROR) ; break;
				case "OFF"   : logger(pkg, OFF)   ; break;
			}
			println "LoggingConfig: Logger set for package[${pkg}] with level[${level}]. "
		}
		catch(Exception e) {
			println "Could not process item[${item}] exception[${e}] message[${e.message}] cause[${e.cause}]"
		}

	}
}

void processRootConf(def config) {
	//Configuracion especifica del ambiente ( sobreescribe a la configuracion basica )
	//mx.com.prosa:DEBUG=FILE-CONSOLE-FILE,
	def items = config//config.getStringArray('LOG.PACKAGES.CONF')
	items.each{ item ->
		try {
			def aux = item.split(":")
			def pkg = aux[0]
			def levelAppender = aux[1]
			def level = levelAppender.split("=")[0]
			def apps = levelAppender.split("=")[1]
			def appenders = apps.split("-") as ArrayList

			//TRACE, DEBUG, INFO, WARN and ERROR

			switch(level) {
				case "TRACE" : logger(pkg, TRACE, appenders) ; break;
				case "DEBUG" : logger(pkg, DEBUG, appenders) ; break;
				case "INFO"  : logger(pkg, INFO, appenders)  ; break;
				case "WARN"  : logger(pkg, WARN, appenders)  ; break;
				case "ERROR" : logger(pkg, ERROR, appenders) ; break;
				case "OFF"   : logger(pkg, OFF, appenders)   ; break;
			}

			println "RootConfig: Logger set for package[${pkg}] with level[${level}] on appenders ${appenders}. "
		}
		catch(Exception e) {
			println "RootConfig: Could not process item[${item}] exception[${e}] message[${e.message}] cause[${e.cause}]"
		}
	}
}

println " ################## ROOT PACKAGES CONFIGURATION #####################   "

if(config.getString('LOG.ROOT.PACKAGES') == null)
	println "There is no environment specific configuration for root packages"
else {
	processRootConf(config.getStringArray('LOG.ROOT.PACKAGES'))
	println " ################## LOG PACKAGES CONFIGURATION #####################   "
	
	if(config.getString('LOG.PACKAGES.CONF') == null)
		println "There is no environment specific configuration for loggers"
	else
		processLoggingConf(config.getStringArray('LOG.PACKAGES.CONF'))

}
println " ################## END LOGBACK CONFIGURATION #####################   "