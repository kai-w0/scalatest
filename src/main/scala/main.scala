import BackStatusEnum.BackStatusEnum
import FrontStatusEnum.{FrontStatus, REQUESTED}

import scala.collection.mutable.ArrayBuffer

//import play.api.libs.json.
object BackStatusEnum extends Enumeration {
  type BackStatusEnum = Value
  val DRAFT, BUILDING, PENDING, INVALID, FAILED, BUILT = Value
}

object FrontStatusEnum extends Enumeration {
  type FrontStatus = Value
  val REQUESTED, FAILED, READY = Value
}

object First {
  def main(args: Array[String]): Unit = {

    def backToFront(backStatus: String): Unit = {
      val input = backStatus.toUpperCase()
      if (input.equals(BackStatusEnum.DRAFT.toString) || input.equals(BackStatusEnum.BUILDING.toString) || input.equals(BackStatusEnum.PENDING.toString)) {
        println(FrontStatusEnum.REQUESTED.toString)
      } else if (input.equals(BackStatusEnum.INVALID.toString) || input.equals(BackStatusEnum.FAILED.toString)) {
        println(FrontStatusEnum.FAILED.toString)
      } else {
        println(FrontStatusEnum.READY.toString)
      }
    }

    def frontToBack(status: String): ArrayBuffer[String] = {
      val arr = new ArrayBuffer[String]()
      val upperStatus = status.toUpperCase()
      if (upperStatus.equals(FrontStatusEnum.REQUESTED.toString)) {
        arr.addOne(BackStatusEnum.DRAFT.toString)
        arr.addOne(BackStatusEnum.BUILDING.toString)
        arr.addOne(BackStatusEnum.PENDING.toString)
      } else if (upperStatus.equals(FrontStatusEnum.FAILED.toString)) {
        arr.addOne(BackStatusEnum.INVALID.toString)
        arr.addOne(BackStatusEnum.FAILED.toString)
      } else {
        arr.addOne(BackStatusEnum.BUILT.toString)
      }
      arr
    }
    def hasStatus(status: Option[FrontStatus]): Unit = {
      if (status.isDefined) {
        if (status.get.toString.equals("REQUESTED")) {
          println("yes")
        } else {
          println("no")
        }
      }
    }
  }
}

