export const UPDATE_QUERY = 'UPDATE_QUERY';
export const UPDATE_DATA = 'UPDATE_DATA';
export const UPDATE_SELECTED = 'UPDATE_SELECTED';

export function updateQuery(query) {
    return { type: UPDATE_QUERY, query };
};

export function updateData(countries) {
    return { type: UPDATE_DATA, countries };
};

export function updateSelected(country) {
    return { type: UPDATE_SELECTED, country };
};
