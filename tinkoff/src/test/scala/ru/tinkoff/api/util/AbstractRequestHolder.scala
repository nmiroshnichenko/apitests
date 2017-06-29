package ru.tinkoff.api.util

import dispatch.{Req, host}
import org.asynchttpclient.Request


abstract class AbstractRequestHolder {
  private val baseHost: Req = host("www.tinkoff.ru").secure
  protected val baseRequest: Req = baseHost / "api" / "v1"

  def request: Request

  override def toString: String = request.toString
}