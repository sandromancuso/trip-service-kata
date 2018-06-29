package user

import "errors"

type Session struct {
}

var session *Session

func CurrentSession() *Session {
	if session == nil {
		session = &Session{}
	}
	return session
}

func (this *Session) GetLoggedUser() (*User, error) {
	return nil, errors.New("Session.GetLoggedUser() should not be called in an unit test")
}
