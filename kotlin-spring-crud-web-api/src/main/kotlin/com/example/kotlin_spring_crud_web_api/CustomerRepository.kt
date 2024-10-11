package com.example.kotlin_spring_crud_web_api

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

interface CustomerRepository {

    fun add(firstName: String, lastName: String): Unit

    fun find(): List<Customer>

    fun update(id: Int, firstName: String, lastName: String)

    fun delete(id: Int)

}

@Repository
class CustomerRepositoryImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : CustomerRepository {
    override fun add(firstName: String, lastName: String) {
        val sql = """
            INSERT INTO
                customer (
                    first_name
                    , last_name
                )
            VALUES (
                :first_name
                , :last_name
            )
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun find(): List<Customer> {
        val sql = """
            SELECT
                id
                , first_name
                , last_name
            FROM
                customer
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
        val customerMap = namedParameterJdbcTemplate.queryForList(sql, sqlParams)
        return customerMap.map {
            Customer(
                it["id"].toString().toInt(),
                it["first_name"].toString(),
                it["last_name"].toString(),
            )
        }
    }

    override fun update(id: Int, firstName: String, lastName: String) {
        val sql = """
            UPDATE
                customer
            SET
                first_name = :first_name
                , last_name = :last_name
            WHERE
                id = :id
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)
            .addValue("id", id)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun delete(id: Int) {
        val sql = """
            DELETE FROM
                customer
            WHERE
                id = :id
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("id", id)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }
}