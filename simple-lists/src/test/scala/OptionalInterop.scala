trait OptionalInterop {
  implicit class EnrichOptional[A](option: java.util.Optional[A]){
    def interop: Option[A] = if(option.isPresent) Some(option.get)
                             else None
  }

  implicit class EnrichOptional2(option: java.util.Optional[Nothing]){
    def interop: Option[Nothing] = None
  }

  implicit class EnrichOption[A](option: Option[A]){
    def interop: Option[A] = option
  }
}
