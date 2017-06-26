package com.gmail.yuriikrat.utils;

/**
 * @author Yurii Krat
 * @version 1.0
 * @since 26.06.17.
 *
 * The <code>QueryLoader</code> interface should be implemented by
 * the classes that are capable of loading queries.
 *
 * Queries should not be coded directly into the statements. Any
 * statement is expected to be loaded by its identifier as follows:
 * <pre>
 *      String query = queryLoader.getQuery("query.identifier");
 * </pre>
 *
 * @see QueryLoaderImpl
 */
public interface QueryLoader {
    /**
     * Loads query by its name
     */
    String getQuery(String queryName);
}
