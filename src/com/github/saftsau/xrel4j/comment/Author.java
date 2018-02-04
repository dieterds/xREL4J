/*
 * Copyright 2017 saftsau
 *
 * This file is part of xREL4J.
 *
 * xREL4J is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * xREL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with xREL4J. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.github.saftsau.xrel4j.comment;

/**
 * Class used to represent authors used on {@link Comment}.
 */
public class Author {

  private String id;
  private String name;

  /**
   * Gets the ID of the author.
   * 
   * @return The ID
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the ID of the author.
   * 
   * @param id The ID to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Gets the name of the author.
   * 
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the author.
   * 
   * @param name The name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Author [getId()=" + getId() + ", getName()=" + getName() + "]";
  }

}