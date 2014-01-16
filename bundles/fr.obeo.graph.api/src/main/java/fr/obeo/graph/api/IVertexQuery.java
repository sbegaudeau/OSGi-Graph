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
 * A VertexQuery object defines a collection of filters and modifiers that are used to intelligently select
 * edges from a vertex.
 * 
 * @author Matthias Brocheler (http://matthiasb.com)
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author Luca Garulli (http://www.orientechnologies.com)
 * @author Daniel Kuppitz (daniel.kuppitz@shoproach.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IVertexQuery extends IQuery {
	/**
	 * The direction of the edges to retrieve.
	 * 
	 * @param direction
	 *            whether to retrieve the incoming, outgoing, or both directions
	 * @return the modified query object
	 */
	IVertexQuery direction(Direction direction);

	/**
	 * Filter out the edge if its label is not in set of provided labels.
	 * 
	 * @param labels
	 *            the labels to check against
	 * @return the modified query object
	 */
	IVertexQuery labels(String... labels);

	/**
	 * Execute the query and return the number of edges that are unfiltered.
	 * 
	 * @return the number of unfiltered edges
	 */
	long count();

	/**
	 * Return the raw ids of the vertices on the other end of the edges.
	 * 
	 * @return the raw ids of the vertices on the other end of the edges
	 */
	Object vertexIds();

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#has(java.lang.String)
	 */
	@Override
	IVertexQuery has(String key);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#hasNot(java.lang.String)
	 */
	@Override
	IVertexQuery hasNot(String key);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#has(java.lang.String, java.lang.Object)
	 */
	@Override
	IVertexQuery has(String key, Object value);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#hasNot(java.lang.String, java.lang.Object)
	 */
	@Override
	IVertexQuery hasNot(String key, Object value);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#has(java.lang.String, fr.obeo.graph.api.IPredicate, java.lang.Object)
	 */
	@Override
	IVertexQuery has(String key, IPredicate predicate, Object value);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#interval(java.lang.String, java.lang.Comparable, java.lang.Comparable)
	 */
	@Override
	IVertexQuery interval(String key, Comparable<?> startValue, Comparable<?> endValue);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.graph.api.IQuery#limit(int)
	 */
	@Override
	IVertexQuery limit(int limit);
}
