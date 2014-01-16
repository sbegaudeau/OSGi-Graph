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
 * A vertex maintains pointers to both a set of incoming and outgoing edges. The outgoing edges are those
 * edges for which the vertex is the tail. The incoming edges are those edges for which the vertex is the
 * head.
 * <p>
 * Diagrammatically, ---inEdges---> vertex ---outEdges--->.
 * </p>
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author Matthias Brocheler (http://matthiasb.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IVertex {
	/**
	 * Return the edges incident to the vertex according to the provided direction and edge labels.
	 * 
	 * @param direction
	 *            The direction of the edges to retrieve
	 * @param labels
	 *            The labels of the edges to retrieve
	 * @return An iterable of incident edges
	 */
	Iterable<IEdge> getEdges(Direction direction, String... labels);

	/**
	 * Return the vertices adjacent to the vertex according to the provided direction and edge labels. This
	 * method does not remove duplicate vertices (i.e. those vertices that are connected by more than one
	 * edge).
	 * 
	 * @param direction
	 *            The direction of the edges of the adjacent vertices
	 * @param labels
	 *            The labels of the edges of the adjacent vertices
	 * @return An iterable of adjacent vertices
	 */
	Iterable<IVertex> getVertices(Direction direction, String... labels);

	/**
	 * Generate a query object that can be used to fine tune which edges/vertices are retrieved that are
	 * incident/adjacent to this vertex.
	 * 
	 * @return A vertex query object with methods for constraining which data is pulled from the underlying
	 *         graph
	 */
	IVertexQuery query();

	/**
	 * Add a new outgoing edge from this vertex to the parameter vertex with provided edge label.
	 * 
	 * @param label
	 *            The label of the edge
	 * @param inVertex
	 *            The vertex to connect to with an incoming edge
	 * @return The newly created edge
	 */
	IEdge addEdge(String label, IVertex inVertex);
}
