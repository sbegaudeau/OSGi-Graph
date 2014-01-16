/********************************************************************************
 * Copyright (c) 2009-2014, TinkerPop [http://tinkerpop.com] and others
 * All rights reserved. This code is available under the New BSD License:
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the TinkerPop nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL TINKERPOP BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Contributors:
 *     Tinkerpop and others - initial API and implementation
 *     Obeo - migration for OSGi, code cleaning
 ********************************************************************************/
package fr.obeo.graph.api;

/**
 * A Graph is a container object for a collection of vertices and a collection edges.
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IGraph {
	/**
	 * Get the particular features of the graph implementation. Not all graph implementations are identical
	 * nor perfectly implement the Blueprints API. The Features object returned contains meta-data about
	 * numerous potential divergences between implementations.
	 * 
	 * @return The features of this particular Graph implementation
	 */
	// Features getFeatures();

	/**
	 * Create a new vertex, add it to the graph, and return the newly created vertex. The provided object
	 * identifier is a recommendation for the identifier to use. It is not required that the implementation
	 * use this identifier.
	 * 
	 * @param id
	 *            The recommended object identifier
	 * @return The newly created vertex
	 */
	IVertex addVertex(Object id);

	/**
	 * Return the vertex referenced by the provided object identifier. If no vertex is referenced by that
	 * identifier, then return null.
	 * 
	 * @param id
	 *            The identifier of the vertex to retrieved from the graph
	 * @return The vertex referenced by the provided identifier or null when no such vertex exists
	 */
	IVertex getVertex(Object id);

	/**
	 * Remove the provided vertex from the graph. Upon removing the vertex, all the edges by which the vertex
	 * is connected must be removed as well.
	 * 
	 * @param vertex
	 *            The vertex to remove from the graph
	 */
	void removeVertex(IVertex vertex);

	/**
	 * Return an iterable to all the vertices in the graph. If this is not possible for the implementation,
	 * then an UnsupportedOperationException can be thrown.
	 * 
	 * @return An iterable reference to all vertices in the graph
	 */
	Iterable<IVertex> getVertices();

	/**
	 * Return an iterable to all the vertices in the graph that have a particular key/value property. If this
	 * is not possible for the implementation, then an UnsupportedOperationException can be thrown. The graph
	 * implementation should use indexing structures to make this efficient else a full vertex-filter scan is
	 * required.
	 * 
	 * @param key
	 *            The key of vertex
	 * @param value
	 *            The value of the vertex
	 * @return An iterable of vertices with provided key and value
	 */
	Iterable<IVertex> getVertices(String key, Object value);

	/**
	 * Add an edge to the graph. The added edges requires a recommended identifier, a tail vertex, an head
	 * vertex, and a label. Like adding a vertex, the provided object identifier may be ignored by the
	 * implementation.
	 * 
	 * @param id
	 *            The recommended object identifier
	 * @param outVertex
	 *            The vertex on the tail of the edge
	 * @param inVertex
	 *            The vertex on the head of the edge
	 * @param label
	 *            The label associated with the edge
	 * @return The newly created edge
	 */
	IEdge addEdge(Object id, IVertex outVertex, IVertex inVertex, String label);

	/**
	 * Return the edge referenced by the provided object identifier. If no edge is referenced by that
	 * identifier, then return null.
	 * 
	 * @param id
	 *            The identifier of the edge to retrieved from the graph
	 * @return The edge referenced by the provided identifier or null when no such edge exists
	 */
	IEdge getEdge(Object id);

	/**
	 * Remove the provided edge from the graph.
	 * 
	 * @param edge
	 *            The edge to remove from the graph
	 */
	void removeEdge(IEdge edge);

	/**
	 * Return an iterable to all the edges in the graph. If this is not possible for the implementation, then
	 * an UnsupportedOperationException can be thrown.
	 * 
	 * @return An iterable reference to all edges in the graph
	 */
	Iterable<IEdge> getEdges();

	/**
	 * Return an iterable to all the edges in the graph that have a particular key/value property. If this is
	 * not possible for the implementation, then an UnsupportedOperationException can be thrown. The graph
	 * implementation should use indexing structures to make this efficient else a full edge-filter scan is
	 * required.
	 * 
	 * @param key
	 *            The key of the edge
	 * @param value
	 *            The value of the edge
	 * @return An iterable of edges with provided key and value
	 */
	Iterable<IEdge> getEdges(String key, Object value);

	/**
	 * Generate a query object that can be used to fine tune which edges/vertices are retrieved from the
	 * graph.
	 * 
	 * @return A graph query object with methods for constraining which data is pulled from the underlying
	 *         graph
	 */
	IGraphQuery query();

	/**
	 * A shutdown function is required to properly close the graph. This is important for implementations that
	 * utilize disk-based serializations.
	 */
	void shutdown();
}
