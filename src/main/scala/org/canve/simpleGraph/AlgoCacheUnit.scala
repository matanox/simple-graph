package org.canve.simpleGraph
import collection.immutable.HashMap

/*
 * a cache using type @VertexCache, 
 * for an algorithm to use against the given @graph
 */
case class AlgoCacheUnit[ID, VertexCacheUnit <: AbstractVertexCacheUnit, Vertex <: AbstractVertex[ID], Edge <: AbstractEdge[ID]]
  (cacheUnit: VertexCacheUnit, 
   graph: AbstractGraph[ID, Vertex, Edge]) { 
   
  private val vertexCacheIndex: Map[ID, AbstractVertexCacheUnit] = 
    graph.vertexIterator.map(vertex => (vertex._1, cacheUnit.apply)).toMap
  
  def apply(id: ID) = vertexCacheIndex.get(id)
}

abstract class AbstractVertexCacheUnit {
  def apply: AbstractVertexCacheUnit
}

