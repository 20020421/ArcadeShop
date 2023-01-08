import { faAngleDown, faPlus } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import classNames from 'classnames/bind';
import { useEffect, useReducer, useRef, useState } from 'react';
import style from './ViewSelect.module.scss';

const cx = classNames.bind(style);

const initState = {
    viewOptions: [
        {
            name: 'All products',
        },
        {
            name: 'Phicay',
        },
    ],
    viewSelected: 'All products',
    isOpenSelect: false,
};

const reducer = (state = initState, action) => {
    switch (action.type) {
        case 'TOGGLE_SELECT':
            return {
                ...state,
                isOpenSelect: !state.isOpenSelect,
            };
        case 'SELECT_VIEW':
            return {
                ...state,
                isOpenSelect: false,
                viewSelected: action.viewName,
            };
        case 'CLOSE_SELECT':
            return {
                ...state,
                isOpenSelect: false,
            };
        default:
            return state;
    }
};

const action = {
    toggleSelect: () => ({
        type: 'TOGGLE_SELECT',
    }),
    selectView: (viewName) => ({
        type: 'SELECT_VIEW',
        viewName,
    }),
    closeSelect: () => ({
        type: 'CLOSE_SELECT',
    }),
};

const viewOptionDefault = [
    {
        name: 'All products',
    },
    {
        name: 'Phicay',
    },
];

function ViewSelect() {
    const [viewState, dispatch] = useReducer(reducer, initState);

    const selectRef = useRef(null);

    useEffect(() => {
        function handleClickOutside(event) {
            if (selectRef.current && !selectRef.current.contains(event.target)) {
                dispatch(action.closeSelect());
            }
        }

        document.addEventListener('mousedown', handleClickOutside);

        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, [selectRef]);

    return (
        <div className={cx('view')} ref={selectRef}>
            <span>View</span>
            <div className={cx('select')}>
                <div className={cx('input')}>
                    <div
                        className={cx('show')}
                        onClick={() => {
                            dispatch(action.toggleSelect());
                        }}
                    >
                        <span>{viewState.viewSelected}</span>
                        <FontAwesomeIcon icon={faAngleDown} />
                    </div>
                    <div className={cx('hide', [viewState.isOpenSelect ? 'open' : ''])}>
                        {viewState.viewOptions.map((option, index) => (
                            <div
                                className={cx('option', [viewState.viewSelected === option.name ? 'selected' : ''])}
                                key={index}
                                onClick={() => {
                                    dispatch(action.selectView(option.name));
                                }}
                            >
                                <span>{option.name}</span>
                            </div>
                        ))}

                        <div className={cx('btn-add-option')}>
                            <FontAwesomeIcon icon={faPlus} />
                            <span>Create New View</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ViewSelect;
