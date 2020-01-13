import React from 'react';
import { connect } from 'react-redux';

import Card from './Card';

import { updateData, updateQuery, updateSelected } from '../actions';
import countries from '../assets/data.json';


class List extends React.PureComponent {
    updateQuery = event => {
        const query = event.target.value;

        this.props.updateQuery(query);
        this.props.updateData(countries.filter(c => {
            let q = query.toLowerCase();

            if (c.state.toLowerCase().includes(q)) return true;
            if (c.city.toLowerCase().includes(q)) return true;
            if (c.station.toLowerCase().includes(q)) return true;

            return false;
        }));
    };

    componentDidMount = () => {
        this.props.updateData(countries);
    };

    render = () => (
        <>
            <div style={{
                display: 'flex',
                alignItems: 'center',
                flexDirection: 'column',
            }}>
                <input
                    type='text'
                    placeholder='Search...'
                    value={ this.props.query }
                    onChange={ this.updateQuery }
                />
                {
                    this.props.country && Object.keys(this.props.country).length
                    ? <Card info={ this.props.country } />
                    : null
                }
            </div>

            <div style={{
                display: 'flex',
                flexWrap: 'wrap',
                justifyContent: 'space-around',
            }}>
                {
                    this.props.countries && this.props.countries.map(data =>
                        <Card
                            key={ data.id }
                            info={ data }
                            onClick={ () => this.props.updateSelected(data) }
                        />
                    )
                }
            </div>
        </>
    );
}


const mapStateToProps = state => ({
    countries: state.countries,
    query: state.query,
    country: state.country,
});

const mapDispatchToProps = { updateData, updateQuery, updateSelected };


export default connect(mapStateToProps, mapDispatchToProps)(List);
