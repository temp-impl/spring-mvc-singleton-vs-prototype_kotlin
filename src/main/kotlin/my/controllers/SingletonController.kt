package my.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Suppress("unused")
@Controller
@RequestMapping("/singleton")
class SingletonController : ControllerBase()
