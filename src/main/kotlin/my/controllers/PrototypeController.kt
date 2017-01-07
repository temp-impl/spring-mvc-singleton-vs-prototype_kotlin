package my.controllers

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Suppress("unused")
@Controller
@Scope("prototype")
@RequestMapping("/prototype")
class PrototypeController : ControllerBase()
