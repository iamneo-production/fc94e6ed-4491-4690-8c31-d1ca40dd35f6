import React from 'react';
import { loadScript, createOptions } from './RazorpayUtils';
import PaymentCofirmation from './PaymentConfirmation';

class RazorpayButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            scriptLoaded: false,
        };
    }

    componentDidMount() {
        loadScript('https://checkout.razorpay.com/v1/checkout.js', () => {
            this.setState({ scriptLoaded: true });
        });
    }

    handleClick = async () => {
        const { scriptLoaded } = this.state;
        if (scriptLoaded) {
            const { amount, currency, onSuccess, onFailure } = this.props;
            const options = createOptions(amount, currency);
            const rzp = new window.Razorpay(options);
            rzp.on('payment.success', onSuccess);
            rzp.on('payment.error', onFailure);
            rzp.open();
        }
    };

    render() {
        return (
            <>
            <button className='btn btn-primary'
                style={{ border: 'none' }} onClick={this.handleClick}>
                Pay
            </button>

                

            </>
        );
    }
}

export default RazorpayButton;