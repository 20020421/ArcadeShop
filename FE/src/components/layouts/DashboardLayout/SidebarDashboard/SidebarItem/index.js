import { faAngleRight, faArrowRight } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import classNames from 'classnames/bind';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import style from './SidebarItem.module.scss';

const cx = classNames.bind(style);

function SidebarItem({ data, isOpen }) {
    return (
        <div className={cx('wrapper', [isOpen ? 'isOpen' : ''])}>
            <Link to={data.to} className={cx('btn')}>
                <span>{data.name}</span>
                <div className={cx('icon')}>{data.children && <FontAwesomeIcon icon={faAngleRight} />}</div>
            </Link>
        </div>
    );
}

export default SidebarItem;
