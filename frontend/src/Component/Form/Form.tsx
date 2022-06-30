import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import styles from './form.module.css';
import axios from 'axios';
import { apiEndpoint } from '../../config';

function Form(props: Object) {

    useEffect(() => {
        getSuperVisors();
    }, [])

    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [selectedSupervisor, setSelectedSupervisor] = useState('');
    const [superVisors, setSupervisors]: any = useState([]);
    const [submitted, setSubmitted] = useState(false);
    const [isEmailSelected, setIsEmailSelected] = useState(false);
    const [isPhoneSelected, setIsPhoneSelected] = useState(false);

    const [formErr, setFormErr]:any = useState({});

    const submitData = async () => {

        if (submitted) {
            return
        }

        setSubmitted(true)
        let req = axios.post(apiEndpoint + 'api/submit', {
            firstName: firstName,
            lastName: lastName,
            email: email,
            phoneNumber: phoneNumber,
            supervisor: selectedSupervisor
        }).then(res => {
            setSubmitted(false)
            resetForm();
            setFormErr({});
            alert("Notification created");
        }).catch(err => {
            console.log(err);
            if(err.response.status == 400){
                setFormErr(err.response.data)
            }
            setSubmitted(false)
            // alert("Internal server Error");
        });
    }

    const resetForm = () => {
        setFirstName('')
        setLastName('')
        setEmail('')
        setSelectedSupervisor('')
        setPhoneNumber('')
        setIsEmailSelected(false)
        setIsPhoneSelected(false)
    }

    const getSuperVisors = () => {
        let req = axios.get(apiEndpoint + 'api/supervisors').then(res => {
            setSupervisors(res.data);
        }).catch(err => {
            alert("Unable to get supervisors");
        });
    }

    return (
        <div>
            <div className={`${styles.row} ${styles.fieldBottomSpace}`}>
                <div className={styles.col6}>
                    <div className={styles.label}>First Name</div>
                    <input onChange={(e) => { setFirstName(e.target.value) }} value={firstName} className={styles.blockInput} type="text" />

                    {formErr.firstName !== undefined && (
                        <div className={styles.danger}>{formErr.firstName}</div>
                    )}
                </div>
                <div className={styles.col6}>
                    <div className={styles.label}>Last Name</div>
                    <input onChange={(e) => { setLastName(e.target.value) }} value={lastName} className={styles.blockInput} type="text" />
                    
                    {formErr.firstName !== undefined && (
                        <div className={styles.danger}>{formErr.lastName}</div>
                    )}
                </div>
            </div>

            <div className={`${styles.row} ${styles.prefer}`}>
                <div>How would you prefer to be notified</div>
            </div>

            <div className={`${styles.row} ${styles.fieldBottomSpace}`}>
                <div className={styles.col6}>
                    <div className={styles.label}>
                        <input onChange={(e) => {setIsEmailSelected(!isEmailSelected)}} checked={isEmailSelected} type="checkbox" name="email" value="Email" />
                        <label>Email</label>
                    </div>
                    <input onChange={(e) => { setEmail(e.target.value) }} value={email} className={styles.blockInput} type="email" name='email' />
                    {formErr.email !== undefined && (
                        <div className={styles.danger}>{formErr.email}</div>
                    )}
                </div>

                <div className={styles.col6}>
                    <div className={styles.label}>
                        <input onChange={(e) => {setIsPhoneSelected(!isPhoneSelected)}} checked={isPhoneSelected} type="checkbox" name="phoneNumber" value="Phone Number" />
                        <label>Phone Number</label>
                    </div>
                    <input onChange={(e) => { setPhoneNumber(e.target.value) }} value={phoneNumber} className={styles.blockInput} type="text" name='email' />
                    {formErr.phoneNumber !== undefined && (
                        <div className={styles.danger}>{formErr.phoneNumber}</div>
                    )}
                </div>
            </div>

            <div className={styles.row}>
                <div className={`${styles.col12} d-h-center`}>
                    <div className='text-left'>
                        <div className={styles.label}>Supervisor</div>
                        <select onChange={(e) => { setSelectedSupervisor(e.target.value) }} name="supervisor" id="supervisor" className={styles.selectBox} value={selectedSupervisor}>
                            <option value="">Select...</option>
                            {superVisors.map((list: any, index: number) => {
                                return (
                                    <option key={index} value={list}>{list}</option>
                                )
                            })}
                        </select>
                        {formErr.supervisor !== undefined && (
                        <div className={styles.danger}>{formErr.supervisor}</div>
                    )}
                    </div>
                </div>
            </div>

            <div className={`${styles.row} ${styles.submitArea}`}>
                <div className={`${styles.col12} d-h-center`}>
                    <div onClick={() => { submitData(); }} className={styles.submit}>Submit</div>
                </div>
            </div>
        </div>
    );
}

export default Form;
