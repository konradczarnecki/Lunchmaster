package com.lunchmaster.api.lunch.dto;

/**
 * Created by m.slefarski on 2017-11-23.
 */
/**
 * LUNCH STATUS
 * NOTE: BELOW DESCRIPTION IS NOT FINAL BY ANY MEANS! IT SHOULD BE DISCUSSED IN DETAIL)
 *
 * State machine is quite simple: OPEN <-> CLOSED -> ORDERED -> DELIVERED -> ARCHIVED
 * All other changes are forbidden and must be restricted by a proper state machine
 *
 * Lunch status description:
 *
 * @OPEN
 * newly created lunch that is open for orders!
 *
 * @CLOSED
 * lunch that is after deadline and orders cannot be placed or edited.
 * This state if from deadline to the moment of food arival. Lunchmaster
 * should be able to re-open closed lunch.
 *
 * @ORDERED
 * order is placed, at this moment under the hood lunch becomes a 'snapshot' in MongoDB
 * to prevent all price changes on orders. After successful transfer lunch is being
 * removed from MySQL.
 * Now (or after lunch :) is the time for all billing operations. Everything except
 * billing options and status change (for lunchmaster) are disabled.
 *
 * @DELIVERED
 * Food is here! Lunchmaster marks lunch as 'delivered' and participants are
 * receiving email/sms. (This status is for users convenience only, nothing
 * changes in workflow).
 *
 * @ARCHIEVED
 * All payments are settled. Lunch becomes uneditable and
 * as a snapshot lands in the Mongo archive collection... FOREVER :)
 */
public enum LunchStatus { OPEN, CLOSED, ORDERED, DELIVERED, ARCHIVED;

}
