import { combineReducers } from 'redux';

import { UPDATE_DATA, UPDATE_QUERY, UPDATE_SELECTED } from '../actions';

const query = (state = '', action) => {
    switch (action.type) {
        case UPDATE_QUERY:
            return action.query;

        default:
            return state;
    }
};

const countries = (state = [], action) => {
    switch (action.type) {
        case UPDATE_DATA:
            return action.countries;

        default:
            return state;
    }
};

const country = (state = {}, action) => {
    switch (action.type) {
        case UPDATE_SELECTED:
            return action.country;

        default:
            return state;
    }
};

export default combineReducers({
    countries,
    query,
    country,
});
