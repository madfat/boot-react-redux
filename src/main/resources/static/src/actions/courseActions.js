import * as types from './actionTypes';
import courseAPI from '../api/mockCourseApi';
import axios from 'axios';
import {beginAjaxCall, ajaxCallError} from './ajaxStatusActions';

export function loadCoursesSuccess(courses) {
    return {type: types.LOAD_COURSES_SUCCESS, courses};
}

export function createCourseSuccess(course) {
    return {type: types.CREATE_COURSE_SUCCESS, course};
}

export function updateCourseSuccess(course) {
    return {type: types.UPDATE_COURSE_SUCCESS, course};
}

export function loadCourses(){
    return function(dispatch){
        dispatch(beginAjaxCall());
        axios.get('/api/courses')
          .then(function(response){
            console.log(response);
            const extracted_courses = response["data"];
            dispatch(loadCoursesSuccess(extracted_courses));
          })
          .catch(function(error){
            console.log(error);
            throw(error);
          });

/*
        return courseAPI.getAllCourses().then(courses =>{
            dispatch(loadCoursesSuccess(courses));
        }).catch(error => {
            throw(error);
        });
*/
    };
}

export function saveCourse(course){
    debugger;
    var data = JSON.stringify(course);
    console.log('b4 save and bfore remove:' + data);

    const removeKey = ['author'];
    removeKey.forEach(function(value){
      delete course[value];
    });

    var data = JSON.stringify(course);
    console.log('b4 save:' + data);
    debugger;
    return function(dispatch, getState){
        dispatch(beginAjaxCall());
        axios.post('/api/courses', course, {header: {"Content-Type": "application/json"} })
          .then(savedCourse =>{
/*
            console.log(savedCourse);
            savedCourse.id == "" ? dispatch(createCourseSuccess(savedCourse) : dispatch(updateCourseSuccess(savedCourse)) );
*/
            dispatch(createCourseSuccess(savedCourse));

          })
          .catch(error =>{
            console.log(error);
            dispatch(ajaxCallError(error));
          }
        );

/*
        return courseAPI.saveCourse(course).then(savedCourse =>{
            course.id ? dispatch(updateCourseSuccess(savedCourse)) : dispatch(createCourseSuccess(savedCourse));
        }).catch(error => {
            dispatch(ajaxCallError(error));
            throw(error);
        });
*/

    };
}
