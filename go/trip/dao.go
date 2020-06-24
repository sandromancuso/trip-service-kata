package trip

import (
	"github.com/pkg/errors"
	"github.com/sandromancuso/trip-service-kata/go/user"
)

type Dao struct {
}

func NewDao() *Dao {
	return &Dao{}
}

func (this *Dao) FindTripByUser(user *user.User) ([]Trip, error) {
	return nil, errors.New("Dao should not be invoked on an unit test")
}
