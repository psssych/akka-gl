//package pl.psych.graphs4s
//
//case class Vertex(i: Int)
//case class Edge(u: Vertex, v: Vertex) {
//  def contains(v: Vertex): Boolean = this.u == v || this.v == v
//
//  def adjacent(v: Vertex): Option[Vertex] =
//    if (this.u == v) Some(this.v) else if (this.v == v) Some(this.u) else None
//}
//
//
//case class Graph(vs: List[Vertex], es: List[Edge]) {
//  def adjacent(v: Vertex): List[Vertex] =
//    for {
//      e <- es
//      maybeAdj <- e.adjacent(v)
//      adj <- maybeAdj
//    } yield adj
//
//}
//
//object lololo {
//  //1) Initialize all vertices as not visited.
//  //2) Do following for every vertex 'v'.
//  //(a) If 'v' is not visited before, call DFSUtil(v)
//  //(b) Print new line character
//  //
//  //DFSUtil(v)
//  //1) Mark 'v' as visited.
//  //2) Print 'v'
//  //3) Do following for every adjacent 'u' of 'v'.
//  //If 'u' is not visited, then recursively call DFSUtil(u)
//
//  def cc(g: Graph): Unit = {
//    g.vs.map { v =>
//
//    }
//  }
//
//  def DFSutil(v: Vertex, g: Graph): Vertex = {
//    println(v)
//    g.adjacent(v)
//    ???
//  }
//}