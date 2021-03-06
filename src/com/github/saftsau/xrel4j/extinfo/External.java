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

package com.github.saftsau.xrel4j.extinfo;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class represents external info an {@link ExtInfo} can contain. Used for adding plots from other
 * websites.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class External {

  private External external;
  @JsonbProperty("link_url")
  @XmlElement(name = "link_url")
  private String linkUrl;
  private String plot;

  /**
   * Gets the information about the external this information comes from.
   * 
   * @return The external
   */
  public External getExternal() {
    return external;
  }

  /**
   * Sets the information about the external this information comes from.
   * 
   * @param external The external to set
   */
  public void setExternal(External external) {
    this.external = external;
  }

  /**
   * Gets the link of this External. This is the link to the original source, not a link to an xREL
   * website where this is embedded.
   * 
   * @return The link
   */
  public String getLinkUrl() {
    return linkUrl;
  }

  /**
   * Sets the link of this External. This is the link to the original source, not a link to an xREL
   * website where this is embedded.
   * 
   * @param linkUrl The link to set
   */
  public void setLinkUrl(String linkUrl) {
    this.linkUrl = linkUrl;
  }

  /**
   * Gets the plot of this External. Can be an empty String if not specified.
   * 
   * @return The plot
   */
  public String getPlot() {
    return plot;
  }

  /**
   * Sets the plot of this External. Use an empty {@link String} to unset.
   * 
   * @param plot The plot to set
   */
  public void setPlot(String plot) {
    this.plot = plot;
  }

  @Override
  public String toString() {
    return "External [getExternal()=" + getExternal() + ", getLinkUrl()=" + getLinkUrl()
        + ", getPlot()=" + getPlot() + "]";
  }
}
