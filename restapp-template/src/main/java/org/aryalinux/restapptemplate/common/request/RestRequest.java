package org.aryalinux.restapptemplate.common.request;

/**
 * @author Chandrakant.Singh
 *
 * @param <E>
 *            This is the DTO Type.
 * 
 *            This is the super class for all requests. getData() should be
 *            overridden to return an object of type entity. Thus in controller,
 *            when getData() would be called, an object of model class would be
 *            created by the DTO, data transferred from the DTO into this object
 *            and returned.
 * 
 *            This can be further used to create/update.
 */
public interface RestRequest<E> {
	E getData();
}
