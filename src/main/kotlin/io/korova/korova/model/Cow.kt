package io.korova.korova.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cows")
data class Cow(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,

  @Column(nullable = false)
  val weight: Float,

  @Column
  val price: Long = 0,
)
