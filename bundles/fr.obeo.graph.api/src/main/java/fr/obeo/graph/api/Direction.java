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
 * Direction is used to denote the direction of an edge or location of a vertex on an edge. For example,
 * gremlin--knows-->rexster is an OUT edge for Gremlin and an IN edge for Rexster. Moreover, given that edge,
 * Gremlin is the OUT vertex and Rexster is the IN vertex.
 * 
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public enum Direction {

	/**
	 * Outgoing.
	 */
	OUT,

	/**
	 * Incoming.
	 */
	IN,

	/**
	 * Incoming and outgoing.
	 */
	BOTH;

	/**
	 * The proper directions IN and OUR.
	 */
	public static final Direction[] PROPER_DIRECTIONS = new Direction[] {OUT, IN };

	/**
	 * Returns the opposite of the direction.
	 * 
	 * @return IN->OUT, OUT->IN, BOTH->BOTH.
	 */
	public Direction opposite() {
		Direction opposite = null;
		if (this.equals(OUT)) {
			opposite = IN;
		} else if (this.equals(IN)) {
			opposite = OUT;
		} else {
			opposite = BOTH;
		}
		return opposite;
	}
}
