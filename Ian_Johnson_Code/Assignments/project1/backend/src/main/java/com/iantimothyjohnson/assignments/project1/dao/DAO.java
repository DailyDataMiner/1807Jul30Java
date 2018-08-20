package com.iantimothyjohnson.assignments.project1.dao;

import java.util.List;

/**
 * A generic interface for a DAO (data access object). The methods contained
 * within this interface constitute the "bare minimum" needed to interact with a
 * database containing objects of the parameter type.
 * 
 * This interface is meant to be extended by other sub-interfaces which which
 * contain methods specific to a particular type (in other words, this interface
 * should be specialized for concrete values of T).
 * 
 * @author Ian Johnson
 *
 * @param <T> the type of object this DAO is specialized to work with
 */
public interface DAO<T> {
    /**
     * Inserts a new element into the database.
     * 
     * Note that, depending on the implementation, certain properties of the
     * given object will be ignored. The most notable example is the ID (which
     * will be overwritten by the value generated by the database), but there
     * may be others (such as the timestamp of a newly-created reimbursement).
     * Any members which are ignored due to such generation will be updated to
     * reflect the values in the database after insertion.
     * 
     * @param obj the object to insert, which should not already be present in
     *            the database. The ID of the object will be updated to
     *            correspond to its generated ID in the database, along with any
     *            other generated values.
     * @return whether the object was actually inserted
     */
    public boolean insert(T obj);

    /**
     * Queries the database for all its elements of this type.
     * 
     * @return a list of all elements in the database
     */
    public List<T> selectAll();

    /**
     * Queries the database for a single element by its (unique) ID.
     * 
     * @param id the ID of the element to find
     * @return the element that was found, or null if there is no element with
     *         the given ID
     */
    public T selectById(int id);

    /**
     * Updates the database for the given object. The database row(s)
     * corresponding to the object will be updated to match the object's
     * property values.
     * 
     * @param obj the object to be updated in the database. The ID member of the
     *            object will be used to identify the row(s) in the database to
     *            be updated.
     * @return whether the database was actually updated
     */
    public boolean update(T obj);

    /**
     * Deletes a single object from the database.
     * 
     * @param id the ID of the object to be deleted
     * @return whether the object was actually deleted
     */
    public boolean delete(int id);
}