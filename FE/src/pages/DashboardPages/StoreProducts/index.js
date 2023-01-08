import classNames from 'classnames/bind';
import style from './StoreProducts.module.scss';
import { Editor } from 'react-draft-wysiwyg';
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import DashboardBtn from '../../../components/DashboardBtn';
import { faPlus, faFilter, faSearch, faMagnifyingGlass } from '@fortawesome/free-solid-svg-icons';

import ViewSelect from './ViewSelect';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { useRef, useState } from 'react';

const cx = classNames.bind(style);

function StoreProducts() {
    const searchRef = useRef();

    const [focused, setFocused] = useState(false);

    return (
        <div className={cx('wrapper')}>
            <div className={cx('top')}>
                <div className={cx('title')}>
                    <h2>
                        Products <span className={cx('number')}>26</span>
                    </h2>
                </div>
                <div className={cx('option')}>
                    <div className={cx('btn-add')}>
                        <DashboardBtn to="/dashboard/products/new-product" primary={true} icon={faPlus}>
                            New Product
                        </DashboardBtn>
                    </div>
                </div>
            </div>
            <div className={cx('container')}>
                <div className={cx('options')}>
                    <ViewSelect />
                    <div className={cx('filter_search')}>
                        <div className={cx('filter')}>
                            <FontAwesomeIcon className={cx('icon')} icon={faFilter} />
                            <span>Filter</span>
                        </div>
                        <div
                            className={cx('search', [focused ? 'focused' : ''])}
                            onClick={() => {
                                searchRef.current.focus();
                            }}
                        >
                            <FontAwesomeIcon className={cx('icon')} icon={faMagnifyingGlass} />
                            <input
                                ref={searchRef}
                                type="text"
                                name="productName"
                                id="productName"
                                placeholder="Search"
                                onFocus={() => {
                                    setFocused(true);
                                }}
                                onBlur={() => {
                                    setFocused(false);
                                }}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default StoreProducts;
