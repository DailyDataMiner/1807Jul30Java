package com.iantimothyjohnson.assignments.banking.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.iantimothyjohnson.assignments.banking.exceptions.AccountAlreadyOwnedByUserException;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountNotFoundException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserAccountDAO {
	private static final Logger LOGGER = Logger.getLogger(UserAccountDAO.class.getName());

	/**
	 * Finds all the accounts associated with the user with the given ID.
	 * 
	 * @param userId The ID of the user whose accounts to find.
	 * @return A list of account IDs associated with the user.
	 */
	public List<Integer> findAccountsForUser(int userId) {
		final String query = "SELECT account_id FROM user_account WHERE user_id = ?";

		List<Integer> accountIds = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accountIds.add(rs.getInt("account_id"));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query database for accounts belonging to a user.", e);
		}
		return accountIds;
	}

	/**
	 * Finds all the user IDs of the owners of the account with the given ID.
	 * 
	 * @param accountId The ID of the account whose owners to find.
	 * @return The user IDs of the given account's owners.
	 */
	public List<Integer> findUsersForAccount(int accountId) {
		final String query = "SELECT user_id FROM user_account WHERE account_id = ?";

		List<Integer> userIds = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userIds.add(rs.getInt("account_id"));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to query database for owners of account.", e);
		}
		return userIds;
	}

	/**
	 * Associates the given user ID with the given account ID. In other words,
	 * specify the user with the given ID as an owner of the account with the given
	 * ID.
	 * 
	 * @param userId    The ID of the user to associate.
	 * @param accountId The ID of the account to associate.
	 */
	public void associate(int userId, int accountId)
			throws UserNotFoundException, AccountNotFoundException, AccountAlreadyOwnedByUserException {
		final String sql = "{CALL associate_user_account(?, ?, ?)}";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, accountId);
			cs.registerOutParameter(3, OracleTypes.NUMBER);
			cs.execute();

			// Check the error code and throw the appropriate exception.
			int errorCode = cs.getInt(3);
			switch (errorCode) {
			case 1:
				throw new UserNotFoundException(userId);
			case 2:
				throw new AccountNotFoundException(accountId);
			case 3:
				throw new AccountAlreadyOwnedByUserException(accountId, userId);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to associate user with account in database.", e);
		}
	}

	/**
	 * Removes all owners from the given account.
	 * 
	 * @param userId The ID of the account whose owners to disassociate.
	 */
	public void disassociateAllForAccount(int accountId) {
		final String sql = "DELETE FROM user_account WHERE account_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to disassociate all of an account's owners.", e);
		}
	}

	/**
	 * Removes all account associations for the given user.
	 * 
	 * @param userId The ID of the user whose accounts to disassociate.
	 */
	public void disassociateAllForUser(int userId) {
		final String sql = "DELETE FROM user_account WHERE user_id = ?";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Unable to disassociate all of a user's accounts.", e);
		}
	}
}