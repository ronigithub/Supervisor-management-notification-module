import React from 'react';
import logo from './logo.svg';
import styles from './header.module.css';

interface props {
    title: string
}

function Header(props: props) {

    const { title } = props

    return (
        <header className={styles.header}>
            <div className={styles.title}>{title}</div>
        </header>
    );
}

export default Header;
