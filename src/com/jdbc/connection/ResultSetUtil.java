package com.jdbc.connection;

/**
 * Utility class that contains separated ResultSet methods for
 * each query
 * 
 * @author RobertoBlanco 
 * @since 2017-10-25
 */

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.java_bean.DeletedOwnerBean;
import com.jdbc.java_bean.DogBean;
import com.jdbc.java_bean.DogKeeperBean;
import com.jdbc.java_bean.NewOwnerBean;

public class ResultSetUtil {
	private static DogBean dogBean = new DogBean();
	private static DogKeeperBean dogKeeperBean = new DogKeeperBean();
	private static NewOwnerBean newOwnerBean = new NewOwnerBean();
	private static DeletedOwnerBean deletedOwnerBean = new DeletedOwnerBean();
	ResultSet resultSet;

	
	/**
	 * Loops through the resultSet and getDogList() and then displays it in the console  
	 * @param resultSet
	 * @return the parameter resultSet
	 */
	public static final ResultSet displayDogResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(dogBean.getDogList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;

	}
	
	/**
	 * Loops through the resultSet and getKeeperList() and then displays it in the console 
	 * @param resultSet
	 * @return the parameter resulSet
	 */
	public static final ResultSet displayDogKeeperResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 3 ; j++) {
					System.out.print(resultSet.getString(dogKeeperBean.getKeeperList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	/**
	 * Loops through the resultSet and getNewOwnerList() and then displays it in the console 
	 * @param resultSet
	 * @return the parameter resultSet
	 */
	public static final ResultSet displayNewOwnerResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	/**
	 * Loops through the resultSet and getDeletedOwnerList() and then displays it in the console 
	 * @param resultSet
	 * @return
	 */
	public static final ResultSet displayDeletedOwnerResult(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(deletedOwnerBean.getDeletedOwnerList().get(j)) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	//END OF SELECT display methods
	
	/**
	 * Displays last resultSet in getDogQueue()
	 * @param resultSet
	 * @return parameter resultSet
	 */
	public static final ResultSet displayLastDogInsertion(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : dogBean.getDogQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	/**
	 * Displays last resultSet in getDogKeeperQueue()
	 * @param resultSet
	 * @return parameter resultSet
	 */
	public static final ResultSet displayInsertKeeperResult(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : dogKeeperBean.getDogKeeperQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	/**
	 * Displays last resultSet in getNewOwnerQueue()
	 * @param resultSet
	 * @return parameter resultSet
	 */
	public static final ResultSet displayInsertNewOwnerResult(ResultSet resultSet) {
		try {
			if(resultSet.last()) {
				for(String element : newOwnerBean.getNewOwnerQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
	
	/**
	 * Displays resultSet in getNewOwnerList() if exists, else shows message
	 * @param resultSet
	 * @return parameter resultSet
	 */
	public static final ResultSet displaySearchtNewOwnerResult(ResultSet resultSet) {
		try {
			if(resultSet.next()) {
				for (int j = 0; j < 5; j++) {
					System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
				} 
				System.out.println();

			}
			else {
				System.out.println("Owner_id doesnt exist.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultSet;
	}
}
