package gens

import scala.util.Random
import CheckResult._

object Gen {
}

object CheckResult {
  def success: CheckResult = Success
  def failure(msg: String): CheckResult = Failure(msg)
}

sealed trait CheckResult

case object Success extends CheckResult

case class Failure(msg: String) extends CheckResult