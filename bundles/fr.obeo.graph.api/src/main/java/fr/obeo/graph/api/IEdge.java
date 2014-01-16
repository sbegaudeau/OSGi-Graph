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
 * An Edge links two vertices. Along with its key/value properties, an edge has both a directionality and a
 * label. The directionality determines which vertex is the tail vertex (out vertex) and which vertex is the
 * head vertex (in vertex). The edge label determines the type of relationship that exists between the two
 * vertices.
 * <p>
 * Diagrammatically, outVertex ---label---> inVertex.
 * </p>
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IEdge {
	/**
	 * Return the tail/out or head/in vertex.
	 * 
	 * @param direction
	 *            Whether to return the tail/out or head/in vertex
	 * @return The tail/out or head/in vertex
	 * @throws IllegalArgumentException
	 *             Is thrown if a direction of both is provided
	 */
	IVertex getVertex(Direction direction) throws IllegalArgumentException;

	/**
	 * Return the label associated with the edge.
	 * 
	 * @return The edge label
	 */
	String getLabel();
}
