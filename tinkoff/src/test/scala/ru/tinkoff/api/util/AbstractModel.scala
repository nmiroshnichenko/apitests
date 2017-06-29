package ru.tinkoff.api.util

import java.util.concurrent.CompletableFuture

import dispatch.Http
import org.asynchttpclient.Response
import org.scalactic.TypeCheckedTripleEquals._
import play.api.libs.json.{JsValue, Json}

abstract class AbstractModel(requestHolder: AbstractRequestHolder) {
  def globResult: Int = responseFuture.get().getStatusCode

  def expectedStatusCode: Int

  def checkResult(): Boolean = globResult === expectedStatusCode

  def responseModel: JsValue = Json.parse(responseFuture.get().getResponseBody)

  var responseFuture = new CompletableFuture[Response]

  def fire(): Unit = {
    val response = Http.default.client.executeRequest(requestHolder.request)
      .toCompletableFuture.get()
    responseFuture.obtrudeValue(response)
  }

  override def toString: String =
    s"${getClass.getName} with expected => actual status code: $expectedStatusCode => $globResult"
}
