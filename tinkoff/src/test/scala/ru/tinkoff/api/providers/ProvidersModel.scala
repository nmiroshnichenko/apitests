package ru.tinkoff.api.providers

import ru.tinkoff.api.util.{AbstractModel, AbstractRequestHolder}

class ProvidersModel(requestHolder: AbstractRequestHolder)
  extends AbstractModel(requestHolder: AbstractRequestHolder) {

  def expectedStatusCode: Int = 200
}
