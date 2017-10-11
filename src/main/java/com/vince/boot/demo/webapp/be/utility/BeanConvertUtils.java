package com.vince.boot.demo.webapp.be.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;


/**
 * The Class BeanConvertUtils.
 */
public class BeanConvertUtils {
	
	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger("BeanConvertUtils");

	/**
	 * Convert simple dao to bean.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param dao the dao
	 * @param beanClass the bean class
	 * @return the v
	 */
	public static <T, V> V convertSimpleDaoToBean(T dao, Class<V> beanClass) {

		V bean = null;
		if (dao != null) {
			try {
				bean = beanClass.newInstance();
				BeanUtils.copyProperties(dao, bean);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dall'entita {} al bean {}", 
						dao.getClass().getSimpleName(),
						(bean != null ? bean.getClass().getSimpleName() : null), 
						e);

				throw new RuntimeException(e);
			}
		}

		return bean;
	}

	/**
	 * Convert simple dao to bean.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param dao the dao
	 * @param beanClass the bean class
	 * @param excludedProperties the excluded properties
	 * @return the v
	 */
	public static <T, V> V convertSimpleDaoToBean(T dao, Class<V> beanClass, String... excludedProperties) {

		V bean = null;
		if (dao != null) {
			try {
				bean = beanClass.newInstance();
				BeanUtils.copyProperties(dao, bean, excludedProperties);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dall'entita {} al bean {}", 
						(bean != null ? bean.getClass().getSimpleName() : null), 
						dao.getClass().getSimpleName(),
						e);

				throw new RuntimeException(e);
			}
		}

		return bean;
	}

	/**
	 * Convert simple bean to transient dao.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param bean the bean
	 * @param daoClass the dao class
	 * @return the t
	 */
	public static <T, V> T convertSimpleBeanToTransientDao(V bean, Class<T> daoClass) {

		T dao = null;
		if (bean != null) {
			try {
				dao = daoClass.newInstance();
				BeanUtils.copyProperties(bean, dao);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dal bean {} all'entita {}", 
						bean.getClass().getSimpleName(), 
						(dao != null ? dao.getClass().getSimpleName() : null),
						e);

				throw new RuntimeException(e);
			}
		}

		return dao;
	}
	
	/**
	 * Convert simple bean to transient dao.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param bean the bean
	 * @param daoClass the dao class
	 * @param excludedProperties the excluded properties
	 * @return the t
	 */
	public static <T, V> T convertSimpleBeanToTransientDao(V bean, Class<T> daoClass, String... excludedProperties) {
		T dao = null;
		
		if (bean != null) {
			try {
				dao = daoClass.newInstance();
				
				BeanUtils.copyProperties(bean, dao, excludedProperties);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dal bean {} all'entita {}", 
						bean.getClass().getSimpleName(), 
						(dao != null ? dao.getClass().getSimpleName() : null),
						e);

				throw new RuntimeException(e);
			}
		}

		return dao;
	}
	
	/**
	 * Convert simple bean to dao.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param bean the bean
	 * @param entity the entity
	 * @param excludedProperties the excluded properties
	 * @return the t
	 */
	public static <T, V> T convertSimpleBeanToDao(V bean, T entity, String... excludedProperties) {
		if (bean != null) {
			try {
				BeanUtils.copyProperties(bean, entity, excludedProperties);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dall'entita {} al bean {}", 
						bean.getClass().getSimpleName(), 
						entity.getClass().getSimpleName(),
						e);
				throw new RuntimeException(e);
			}
		}

		return entity;
	}		

	/**
	 * Convert simple bean to dao.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param bean the bean
	 * @param entity the entity
	 * @return the t
	 */
	public static <T, V> T convertSimpleBeanToDao(V bean, T entity) {
		if (bean != null) {
			try {
				BeanUtils.copyProperties(bean, entity);

			} catch (Throwable e) {
				// should never go there
				LOGGER.error("Errore nel copiare le proprieta' dall'entita {} al bean {}", 
						bean.getClass().getSimpleName(), 
						entity.getClass().getSimpleName(),
						e);
				throw new RuntimeException(e);
			}
		}

		return entity;
	}	
	
	/**
	 * Transform simple dao list to beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoList the dao list
	 * @param beanClass the bean class
	 * @return the list
	 */
	public static <T, V> List<V> transformSimpleDaoListToBeans(List<T> daoList, Class<V> beanClass) {

		List<V> result = new ArrayList<>();

		if (daoList != null && !daoList.isEmpty()) {
			for (T dao : daoList)
				result.add(convertSimpleDaoToBean(dao, beanClass));
		}

		return result;
	}

	/**
	 * Transform simple dao list to beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoList the dao list
	 * @param beanClass the bean class
	 * @param excludedProperties the excluded properties
	 * @return the list
	 */
	public static <T, V> List<V> transformSimpleDaoListToBeans(List<T> daoList, Class<V> beanClass,
			String... excludedProperties) {

		List<V> result = new ArrayList<>();

		if (daoList != null && !daoList.isEmpty()) {
			for (T dao : daoList)
				result.add(convertSimpleDaoToBean(dao, beanClass, excludedProperties));
		}

		return result;
	}

	/**
	 * Transform simple dao page to page beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoPage the dao page
	 * @param beanClass the bean class
	 * @return the page bean
	 */
	public static <T, V> PagedListHolder<V> transformSimpleDaoPageToPageBeans(Page<T> daoPage, Class<V> beanClass) {

		List<V> result = new ArrayList<>();
		PagedListHolder<V> pageBean = new PagedListHolder<>();

		List<T> pageDaoList = daoPage.getContent();

		if (pageDaoList != null && !pageDaoList.isEmpty()) {
			for (T dao : pageDaoList)
				result.add(convertSimpleDaoToBean(dao, beanClass));
		}

		pageBean.setSource(result);
//		pageBean.setTotalElements(Long.valueOf(daoPage.getTotalElements()));

		return pageBean;
	}

	/**
	 * Transform simple dao page to page beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoPage the dao page
	 * @param beanClass the bean class
	 * @param excludedProperties the excluded properties
	 * @return the page bean
	 */
	public static <T, V> PagedListHolder<V> transformSimpleDaoPageToPageBeans(Page<T> daoPage, Class<V> beanClass,
			String... excludedProperties) {

		List<V> result = new ArrayList<>();
		PagedListHolder<V> pageBean = new PagedListHolder<>();

		List<T> pageDaoList = daoPage.getContent();

		if (pageDaoList != null && !pageDaoList.isEmpty()) {
			for (T dao : pageDaoList)
				result.add(convertSimpleDaoToBean(dao, beanClass, excludedProperties));
		}

		pageBean.setSource(result);
//		pageBean.setTotalElements(Long.valueOf(daoPage.getTotalElements()));

		return pageBean;
	}

	/**
	 * Transform simple dao list to beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoList the dao list
	 * @param beanClass the bean class
	 * @return the sets the
	 */
	public static <T, V> Set<V> transformSimpleDaoListToBeans(Set<T> daoList, Class<V> beanClass) {

		Set<V> result = new HashSet<>();

		if (daoList != null && !daoList.isEmpty()) {
			for (T dao : daoList)
				result.add(convertSimpleDaoToBean(dao, beanClass));
		}

		return result;
	}

	/**
	 * Transform simple dao list to beans.
	 *
	 * @param <T> the generic type
	 * @param <V> the value type
	 * @param daoList the dao list
	 * @param beanClass the bean class
	 * @param excludedProperties the excluded properties
	 * @return the sets the
	 */
	public static <T, V> Set<V> transformSimpleDaoListToBeans(Set<T> daoList, Class<V> beanClass,
			String... excludedProperties) {

		Set<V> result = new HashSet<>();

		if (daoList != null && !daoList.isEmpty()) {
			for (T dao : daoList)
				result.add(convertSimpleDaoToBean(dao, beanClass, excludedProperties));
		}

		return result;
	}

}
