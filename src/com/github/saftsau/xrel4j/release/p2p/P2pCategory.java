/*
 * Copyright 2017, 2018 saftsau
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

package com.github.saftsau.xrel4j.release.p2p;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class represents a category as used in the P2P section on xREL.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "category")
public class P2pCategory {

  @JsonbProperty("meta_cat")
  @XmlElement(name = "meta_cat")
  private String metaCat;
  @JsonbProperty("sub_cat")
  @XmlElement(name = "sub_cat")
  private String subCat;
  private String id;

  /**
   * Gets the meta category. Can be seen as a parent category.
   * 
   * @return The meta category
   */
  public String getMetaCat() {
    return metaCat;
  }

  /**
   * Sets the meta category. Can be seen as a parent category.
   * 
   * @param metaCat The meta category to set
   */
  public void setMetaCat(String metaCat) {
    this.metaCat = metaCat;
  }

  /**
   * Gets the sub category. Can be seen as the name of this P2pCategory.
   * 
   * @return The sub category
   */
  public String getSubCat() {
    return subCat;
  }

  /**
   * Sets the sub category. Can be seen as the name of this P2pCategory.
   * 
   * @param subCat The sub category to set
   */
  public void setSubCat(String subCat) {
    this.subCat = subCat;
  }

  /**
   * Gets the API ID of this P2pCategory.
   * 
   * @return The ID
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the API ID of this P2pCategory.
   * 
   * @param id The ID to set
   */
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "P2pCategory [getMetaCat()=" + getMetaCat() + ", getSubCat()=" + getSubCat()
        + ", getId()=" + getId() + "]";
  }

}
