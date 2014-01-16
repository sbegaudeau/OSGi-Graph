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
 * Common superinterface for vertex and graph queries.
 * 
 * @author Matthias Broecheler (me@matthiasb.com)
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author Luca Garulli (http://www.orientechnologies.com)
 * @author Daniel Kuppitz (daniel.kuppitz@shoproach.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IQuery {
	/**
	 * Filter out elements that do not have a property with provided key.
	 * 
	 * @param key
	 *            the key of the property
	 * @return the modified query object
	 */
	IQuery has(String key);

	/**
	 * Filter out elements that have a property with provided key.
	 * 
	 * @param key
	 *            the key of the property
	 * @return the modified query object
	 */
	IQuery hasNot(String key);

	/**
	 * Filter out elements that do not have a property value equal to provided value.
	 * 
	 * @param key
	 *            the key of the property
	 * @param value
	 *            the value to check against
	 * @return the modified query object
	 */
	IQuery has(String key, Object value);

	/**
	 * Filter out elements that have a property value equal to provided value.
	 * 
	 * @param key
	 *            the key of the property
	 * @param value
	 *            the value to check against
	 * @return the modified query object
	 */
	IQuery hasNot(String key, Object value);

	/**
	 * Filter out the element if it does not have a property with a comparable value.
	 * 
	 * @param key
	 *            the key of the property
	 * @param predicate
	 *            the comparator to use for comparison
	 * @param value
	 *            the value to check against
	 * @return the modified query object
	 */
	IQuery has(String key, IPredicate predicate, Object value);

	/**
	 * Filter out the element of its property value is not within the provided interval.
	 * 
	 * @param key
	 *            the key of the property
	 * @param startValue
	 *            the inclusive start value of the interval
	 * @param endValue
	 *            the exclusive end value of the interval
	 * @return the modified query object
	 */
	IQuery interval(String key, Comparable<?> startValue, Comparable<?> endValue);

	/**
	 * Filter out the element if the take number of incident/adjacent elements to retrieve has already been
	 * reached.
	 * 
	 * @param limit
	 *            the take number of elements to return
	 * @return the modified query object
	 */
	IQuery limit(int limit);

	/**
	 * Execute the query and return the matching edges.
	 * 
	 * @return the unfiltered incident edges
	 */
	Iterable<IEdge> edges();

	/**
	 * Execute the query and return the vertices on the other end of the matching edges.
	 * 
	 * @return the unfiltered adjacent vertices
	 */
	Iterable<IVertex> vertices();
}
