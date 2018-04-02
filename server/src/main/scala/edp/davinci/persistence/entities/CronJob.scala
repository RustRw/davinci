package edp.davinci.persistence.entities

import edp.davinci.persistence.base.{BaseEntity, BaseTable}
import slick.jdbc.MySQLProfile.api._

case class CronJob(id: Long,
                   name: String,
                   job_type: String,
                   job_status: String,
                   cron_pattern: String,
                   start_date:String,
                   end_date:String,
                   config: String,
                   desc: Option[String],
                   exec_log: String,
                   create_by: Long,
                   create_time: String,
                   update_time: String
                  ) extends BaseEntity


case class PostCronJob(name: String,
                       job_type: String,
                       cron_pattern: String,
                       start_date:String,
                       end_date:String,
                       config: String,
                       desc: Option[String])


case class PutCronJob(id: Long,
                      name: String,
                      job_type: String,
                      cron_pattern: String,
                      start_date:String,
                      end_date:String,
                      config: String,
                      desc: Option[String])


case class PostCronJobSeq(payload: Seq[PostCronJob])

case class PutCronJobSeq(payload: Seq[PutCronJob])

case class CronJobSeq(payload:Seq[CronJob])


case class EmailCronJobConfig(toAddress: String, cc: String, subject: String, contentURL: String)

class CronJobTable(tag: Tag) extends BaseTable[CronJob](tag, "cronjob") {
  //  def name = column[String]("name")
  def job_type = column[String]("job_type")

  def job_status = column[String]("job_status")

  def cron_pattern = column[String]("cron_pattern")

  def start_date = column[String]("start_date")

  def end_date = column[String]("end_date")

  def config = column[String]("config")

  def desc = column[Option[String]]("desc")

  def exec_log = column[String]("exec_log")

  def create_time = column[String]("create_time")

  def create_by = column[Long]("create_by")

  def update_time = column[String]("update_time")

  def * = (id, name, job_type, job_status, cron_pattern,start_date,end_date, config, desc, exec_log, create_by, create_time, update_time) <> (CronJob.tupled, CronJob.unapply)
}