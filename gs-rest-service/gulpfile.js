"use strict";

var gulp = require('gulp'), //������down�����Ĳ����Ҫ���룬�Ա���Ҫ
    gutil = require('gulp-util'),
    wiredep = require('wiredep').stream

gulp.task('html', function() {  // ����task����:������cmd������ִ������
  gulp.src('src/main/webapp/index.html')
    .pipe(wiredep({  // ���ò��wiredepִ�з���
      optional: 'configuration',
      goes: 'here'
    }))
    .pipe(gulp.dest('src/main/webapp'))
})