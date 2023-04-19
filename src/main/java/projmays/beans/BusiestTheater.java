/**
 * 
 */
package projmays.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Austin Mays - ajmays CIS175 - Spring 2023 04/07/2023
 */

@Entity
@Table(name = "busiest_theater")
@Embeddable
public class BusiestTheater {
	@Id
	@GeneratedValue
	@Column(name = "theater")
	private int busiestTheaterNum;

	public BusiestTheater() {
		super();
	}

	public BusiestTheater(int busiestTheater) {
		super();
		this.busiestTheaterNum = busiestTheater;
	}

	public int getBusiestTheaterNum() {
		return busiestTheaterNum;
	}

	public void setBusiestTheaterNum(int busiestTheaterNum) {
		this.busiestTheaterNum = busiestTheaterNum;
	}

	@Override
	public String toString() {
		return "Busiest Theaters: " + busiestTheaterNum;
	}
}
