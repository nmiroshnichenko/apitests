package ru.tinkoff.api.providers

import org.asynchttpclient.Request
import ru.tinkoff.api.util.AbstractRequestHolder

case class ProvidersRequestHolder(groups: Some[String]) extends AbstractRequestHolder {
  private val providersRequest = baseRequest / "providers"

  override def request: Request = {
    providersRequest.addQueryParameter("groups", groups.get).toRequest
  }
}
