package io.korova.korova.model

import org.springframework.stereotype.Service

@Service
class CowService (val db: CowRepository) {
  fun findCows(): List<Cow> = db.findAll().toList()

  fun findById(id: Long) = db.findById(id)

  fun save(cow: Cow) {
    db.save(cow)
  }
}
