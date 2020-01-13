import React from 'react';

export default ({ info, onClick }) => (
    <div
        style={{
            padding: 20,
            margin: 15,
            width: 300,
            display: 'flex',
            flexDirection: 'column',
            backgroundColor: '#F0F0F0',
            borderRadius: 5,
            textAlign: 'left',
            boxShadow: '0 5px 5px 0px rgba(100, 100, 100, .1)',
            cursor: 'pointer',
        }}
        onClick={ onClick }
    >
        <div>{ info.country }</div>
        <div>{ info.state }</div>
        <div>{ info.city }</div>
        <div>{ info.station }</div>
    </div>
);
