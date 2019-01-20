package org.craftedsw.tripservicekata.infrastructure

import org.scalatest._
import org.scalatest.mockito.MockitoSugar

abstract class UnitSpec extends FlatSpec
							with Matchers
							with OptionValues
							with Inside
							with Inspectors
							with MockitoSugar
