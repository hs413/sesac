import React from "react";
import Notification from "./Notification";

const reserveNotifications = [
    {
        id: 1,
        message: "안녕"
    },
    {
        id: 2,
        message: "하세요",
    },
    {
        id: 3,
        message: "미팅 시작"
    }
]

var timer;

class NotificationList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            notifications: [],
        }
    }

    componentDidMount() {
        const { notifications } = this.state;
        timer = setInterval(() => {
            if (notifications.length < reserveNotifications.length) {
                const index = notifications.length;
                notifications.push(reserveNotifications[index]);
                this.setState({
                    notifications: notifications,
                })
            } else {
                this.setState({
                    notifications: []
                });
                clearInterval(timer);
            }
        }, 1000);
    }

    componentWillUnmount() {
        if (timer) {
            clearInterval(timer);
        }
    }

    render() {
        return (
            <div>
                {this.state.notifications.map((notification) => {
                    return (
                        <Notification key={notification.id} id={notification.id} message={notification.message} />
                    )
                })}
            </div>
        )
    }
}

export default NotificationList;