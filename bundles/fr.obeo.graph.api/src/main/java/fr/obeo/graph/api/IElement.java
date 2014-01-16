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

import java.util.Set;

/**
 * An Element is the base class for both vertices and edges. An element has an identifier that must be unique
 * to its inheriting classes (vertex or edges). An element can maintain a collection of key/value properties.
 * Keys are always Strings and values can be any Object. Particular implementations can reduce the space of
 * objects that can be used as values. Typically, objects are Java primitives (e.g. String, long, int,
 * boolean, etc.)
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public interface IElement {
	/**
	 * Return the object value associated with the provided string key. If no value exists for that key,
	 * return null.
	 * 
	 * @param key
	 *            The key of the key/value property
	 * @return The object value related to the string key
	 */
	Object getProperty(String key);

	/**
	 * Return all the keys associated with the element.
	 * 
	 * @return The set of all string keys associated with the element
	 */
	Set<String> getPropertyKeys();

	/**
	 * Assign a key/value property to the element. If a value already exists for this key, then the previous
	 * key/value is overwritten.
	 * 
	 * @param key
	 *            The string key of the property
	 * @param value
	 *            The object value o the property
	 */
	void setProperty(String key, Object value);

	/**
	 * Un-assigns a key/value property from the element. The object value of the removed property is returned.
	 * 
	 * @param key
	 *            the key of the property to remove from the element
	 * @return The object value associated with that key prior to removal
	 */
	Object removeProperty(String key);

	/**
	 * Remove the element from the graph.
	 */
	void remove();

	/**
	 * An identifier that is unique to its inheriting class. All vertices of a graph must have unique
	 * identifiers. All edges of a graph must have unique identifiers.
	 * 
	 * @return The identifier of the element
	 */
	Object getId();
}
