package writer

case class ListWriter[A, W](value: A, output: List[W]) {
  def map[B](f: A => B): ListWriter[B, W] = copy(value = f(value))
  def flatMap[B](f: A => ListWriter[B, W]): ListWriter[B, W] = {
    val w = f(value)
    w.copy(output = output ++ w.output)
  }
  def tell(w: W): ListWriter[A, W] = copy(output = output :+ w)
  def listen: ListWriter[(A, List[W]), W] = copy(value = (value, output))
  def mapOutput(f: List[W] => List[W]): ListWriter[A, W] = copy(output = f(output))
}

object ListWriter {
  def writer[A, W](value: A, output: W*): ListWriter[A, W] = ListWriter(value, output.toList)
  def tell[W](w: W): ListWriter[Unit, W] = ListWriter((), List(w))
}
