package com.gu.scanamo.filters

import com.amazonaws.services.dynamodbv2.model.AttributeValue

sealed trait Filter {
  val stringExpression: String
  val placeHolder: String
  val attributeValue: AttributeValue
}

case class BeginsWith(fieldName: String, text: String) extends Filter{
  val placeHolder = ":filterValue"
  val stringExpression: String = s"begins_with($fieldName, :filterValue)"
  val attributeValue = new AttributeValue().withS(text)
}
