package mx.com.sagarpa.snics.persistence.impl

import org.hibernate.criterion.Criterion
import org.hibernate.criterion.Restrictions

/**
 * @author r0tten
 *
 */
class GenericDaoHelper {
	public static List<Criterion> getCriteria(def sample, String persistenceClassId, List persistenceClassSkippedProperties) {

		List<Criterion> l = new ArrayList<Criterion>()

		sample.getProperties().each {

			if(it.getKey().equals("class") || it.getKey().equals("metaClass"))
				return

			if(it.getKey().equals(persistenceClassId)) {
				if(it.value)
					l.add(Restrictions.eq(persistenceClassId, it.value))
			}
			else {
				if(persistenceClassSkippedProperties.contains((it.key)))
					return

				if(it.value)
					l.add(Restrictions.like(it.key, it.value))
			}
		}

		return l
	}
}
