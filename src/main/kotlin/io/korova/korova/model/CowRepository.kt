package io.korova.korova.model

import org.springframework.data.repository.CrudRepository

interface CowRepository : CrudRepository<Cow, Long>
